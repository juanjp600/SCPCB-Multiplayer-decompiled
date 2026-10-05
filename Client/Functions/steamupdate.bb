Function steamupdate%()
    steam_update()
    steam_setacceptlobbyinvites($01)
    networkserver\Field37 = ((steam_getlobbystate() = $01) Or (steam_getlobbystate() = $02))
    If ((((steam_getlobbystate() = $01) And (prevlobbystate <> $01)) And (networkserver\Field36 = $00)) <> 0) Then
        networkserver\Field36 = $01
        udp_writebyte($7E)
        udp_writebyte($00)
        udp_sendmessageinternal($00, steam_getlobbyowneridupper(), steam_getlobbyowneridlower(), $00)
        networkserver\Field36 = $00
    EndIf
    prevlobbystate = steam_getlobbystate()
    If (steam_rich_presence_update < millisecs()) Then
        ws_checksubscribeditems($00)
        If (mainmenuopen <> 0) Then
            If (udp_getstream() <> 0) Then
                steam_setrichpresence("steam_display", "#Status_WaitingForMatch")
            EndIf
        ElseIf (udp_getstream() = $00) Then
            steam_setrichpresence("steam_display", "#Status_InGame")
        Else
            steam_setrichpresence("steam_display", "#Status_InGame")
        EndIf
        steam_rich_presence_update = (millisecs() + $BB8)
    EndIf
    If (steamrefreshfriendlist < millisecs()) Then
        getsteamfriends()
        steamrefreshfriendlist = (millisecs() + $493E0)
    EndIf
    Return $00
End Function
