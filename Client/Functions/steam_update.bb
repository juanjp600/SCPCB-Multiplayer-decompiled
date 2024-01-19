Function steam_update%()
    bs_steamapi_runcallbacks()
    If (steam_rich_presence_update < millisecs()) Then
        ws_checksubscribeditems($00)
        If (mainmenuopen <> 0) Then
            If (udp_getstream() <> 0) Then
                bs_isteamfriends_setrichpresence(bs_steamfriends(), "steam_display", "#Status_WaitingForMatch")
                discord_api_setstate("In lobby", $00)
                If (networkserver\Field49 = $00) Then
                    bs_isteamuser_advertisegame(bs_steamuser(), bs_steamclient_steamidnonsteamgs, udp_network\Field1, udp_network\Field2)
                    bs_isteamfriends_setrichpresence(bs_steamfriends(), "connect", (((Str udp_network\Field1) + ":") + (Str udp_network\Field2)))
                Else
                    bs_isteamuser_advertisegame(bs_steamuser(), bs_steamclient_steamidnil, $00, $00)
                    bs_isteamfriends_setrichpresence(bs_steamfriends(), "connect", "")
                EndIf
            Else
                bs_isteamfriends_setrichpresence(bs_steamfriends(), "steam_display", "#Status_AtMainMenu")
                discord_api_setstate("In main menu", $00)
                bs_isteamfriends_setrichpresence(bs_steamfriends(), "connect", "")
                bs_isteamuser_advertisegame(bs_steamuser(), bs_steamclient_steamidnil, $00, $00)
            EndIf
        ElseIf (udp_getstream() = $00) Then
            bs_isteamuser_advertisegame(bs_steamuser(), bs_steamclient_steamidnil, $00, $00)
            bs_isteamfriends_setrichpresence(bs_steamfriends(), "connect", "")
            bs_isteamfriends_setrichpresence(bs_steamfriends(), "steam_display", "#Status_InGame")
            discord_api_setstate("Playing on a server", $00)
        Else
            If (networkserver\Field49 = $00) Then
                bs_isteamuser_advertisegame(bs_steamuser(), bs_steamclient_steamidnonsteamgs, udp_network\Field1, udp_network\Field2)
                bs_isteamfriends_setrichpresence(bs_steamfriends(), "connect", (((Str udp_network\Field1) + ":") + (Str udp_network\Field2)))
            Else
                bs_isteamuser_advertisegame(bs_steamuser(), bs_steamclient_steamidnil, $00, $00)
                bs_isteamfriends_setrichpresence(bs_steamfriends(), "connect", "")
            EndIf
            bs_isteamfriends_setrichpresence(bs_steamfriends(), "steam_display", "#Status_InGame")
            discord_api_setstate("Playing on a server", $00)
        EndIf
        steam_rich_presence_update = (millisecs() + $BB8)
    EndIf
    Return $00
End Function
