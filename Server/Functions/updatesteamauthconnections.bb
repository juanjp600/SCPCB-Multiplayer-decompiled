Function updatesteamauthconnections%()
    Local local0.authconnection
    Local local1$
    Local local3%
    Local local4%
    gs_update()
    updatesteamgameserverconnection()
    For local0 = Each authconnection
        If (local0\Field7 = steam_idtostring(steam_getauthsessionresponseidupper(), steam_getauthsessionresponseidlower())) Then
            local0\Field10 = steam_getauthsessionresponse()
            Select local0\Field10
                Case $00
                    sendserverdatatoplayer(local0\Field0, local0\Field1)
                Case $01
                    local1 = "You are not connected to Steam."
                Case $02
                    local1 = "You do not own this game, or your Steam session has expired."
                Case $03
                    local1 = "You are VAC banned and cannot join this server."
                Case $04
                    local1 = "Your Steam account is logged in somewhere else."
                Case $05
                    local1 = "Steam authentication timed out. Please try again."
                Case $06
                    local1 = "Your Steam authentication was canceled."
                Case $07
                    local1 = "Your Steam authentication ticket has already been used."
                Case $08
                    local1 = "Your Steam authentication ticket is invalid."
                Case $09
                    local1 = "You are banned from this game and cannot join this server."
                Case $0A
                    local1 = "Steam could not verify your network identity. Please try again."
            End Select
            If (local1 <> "") Then
                udp_writebyte($71)
                udp_writeline(local1)
                sendudpmsg(server\Field0, local3, local4)
                addlog(((local0\Field2 + " could not connect due to: ") + local1), $00, $00, $00, $C0, $C0, $C0)
                removeauthconnection(local0)
            EndIf
        EndIf
        If ((local0\Field8 - $5DC) < millisecs()) Then
            removeauthconnection(local0)
        EndIf
    Next
    Return $00
End Function
