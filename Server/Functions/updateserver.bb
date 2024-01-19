Function updateserver%()
    Local local0%
    Local local1$
    If (getscripts() <> 0) Then
        public_inqueue($05, $01)
    EndIf
    updatesteamauthconnections()
    mp_updateplayers($01)
    updatetimers()
    updateplayerscount()
    updatechat()
    breach_update()
    kick_updater()
    updatefakeplayers()
    updatequerys()
    If (istimedout($03, server\Field4) <> 0) Then
        server_network_update()
        chat_network_update()
        objects_network_update()
        draws_network_update()
        texts_network_update()
        server\Field49 = (Int reverseto((Float (server\Field49 + $01)), 1.0, 7.0))
        misc_network_update(server\Field49)
    EndIf
    If (istimedout($04, $5DC) <> 0) Then
        For local0 = $01 To server\Field11 Step $01
            udp_writebyte($64)
            udp_writebyte($01)
            udp_sendmessage(playeroptimize[local0]\Field30)
            playeroptimize[local0]\Field42 = millisecs()
        Next
    EndIf
    dynamic_shoot_ticks = (Int max(min((fpsfactor * 3.0), 1.0), 2.0))
    local1 = errorlogex()
    If (((local1 <> "") And (errorupd < millisecs())) <> 0) Then
        addlog(("Detected error: " + local1), $00, $00, $00)
        errorupd = (millisecs() + $3E8)
    EndIf
    Return $00
End Function
