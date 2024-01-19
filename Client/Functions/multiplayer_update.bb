Function multiplayer_update%()
    If (online_update < millisecs()) Then
        sendstatisticrequest($10)
        online_update = (millisecs() + $EA60)
    EndIf
    steam_update()
    discord_api_update()
    multiplayer_list_serverlistudpmsgs()
    multiplayer_updateconnection()
    If (udp_getstream() <> 0) Then
        Return multiplayer_main()
    EndIf
    Return $00
End Function
