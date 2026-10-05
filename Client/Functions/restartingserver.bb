Function restartingserver%(arg0$, arg1%)
    Local local0%
    Local local1%
    Local local2.servers
    Local local3%
    Local local4%
    Local local5%
    Local local6%
    local0 = (millisecs() + $3A98)
    For local2 = Each servers
        local2\Field4 = $00
    Next
    flushkeys()
    While (keyhit($01) = $00)
        clscolor($00, $00, $00, $FF)
        cls()
        steamupdate()
        discord_api_update()
        If (selectedloadingscreen\Field6 = $00) Then
            drawimage(loadingback, (viewport_center_x - (imagewidth(loadingback) Sar $01)), (viewport_center_y - (imageheight(loadingback) Sar $01)), $00)
        EndIf
        If (selectedloadingscreen\Field6 = $00) Then
            drawimage(loadingback, (viewport_center_x - (imagewidth(loadingback) Sar $01)), (viewport_center_y - (imageheight(loadingback) Sar $01)), $00)
        EndIf
        If (selectedloadingscreen\Field4 = $00) Then
            local3 = (viewport_center_x - (imagewidth(selectedloadingscreen\Field1) Sar $01))
        ElseIf (selectedloadingscreen\Field4 = $01) Then
            local3 = (graphicwidth - imagewidth(selectedloadingscreen\Field1))
        Else
            local3 = $00
        EndIf
        If (selectedloadingscreen\Field5 = $00) Then
            local4 = (viewport_center_y - (imageheight(selectedloadingscreen\Field1) Sar $01))
        ElseIf (selectedloadingscreen\Field5 = $01) Then
            local4 = (graphicheight - imageheight(selectedloadingscreen\Field1))
        Else
            local4 = $00
        EndIf
        drawimage(selectedloadingscreen\Field1, local3, local4, $00)
        local5 = $12C
        local6 = $14
        local3 = (viewport_center_x - (local5 Sar $01))
        local4 = ((viewport_center_y + $1E) - $64)
        setcolorex($00, $00, $00)
        setfontex(fonts[$01]\Field0)
        text((viewport_center_x + $01), ((viewport_center_y + $50) + $01), selectedloadingscreen\Field3, $01, $01)
        setfontex(fonts[$00]\Field0)
        rowtext(selectedloadingscreen\Field7[loadingscreentext], (Float ((viewport_center_x - $C8) + $01)), (Float ((viewport_center_y + $78) + $01)), 400.0, 300.0, $01, 1.0, $00)
        setcolorex($FF, $FF, $FF)
        setfontex(fonts[$01]\Field0)
        text(viewport_center_x, (viewport_center_y + $50), selectedloadingscreen\Field3, $01, $01)
        setfontex(fonts[$00]\Field0)
        rowtext(selectedloadingscreen\Field7[loadingscreentext], (Float (viewport_center_x - $C8)), (Float (viewport_center_y + $78)), 400.0, 300.0, $01, 1.0, $00)
        setfontex(fonts[$01]\Field0)
        setcolorex($AA, $AA, $AA)
        text(viewport_center_x, (Int ((Float viewport_center_y) - (200.0 * menuscale))), "SERVER IS RESTARTING", $01, $01)
        setcolorex($FF, $FF, $FF)
        setfontex(fonts[$00]\Field0)
        text((Int (20.0 * menuscale)), (Int (20.0 * menuscale)), "Press ESC To exit", $00, $00)
        drawquickclues()
        If (local0 < millisecs()) Then
            For local2 = Each servers
                If (((local2\Field1 = arg0) And (local2\Field2 = (Str arg1))) <> 0) Then
                    If (local2\Field4 <> $00) Then
                        multiplayer_connectto(arg0, arg1, password, $00, $1388)
                    Else
                        multiplayer_list_updateserver(local2, $1388, $01)
                    EndIf
                    Exit
                EndIf
            Next
            local0 = (millisecs() + $1388)
            local1 = (local1 + $01)
        EndIf
        multiplayer_list_serverlistudpmsgs()
        multiplayer_updateconnection()
        updateresolution($00)
        updatevsync($01)
        shouldrestartserver = $00
        If ((udp_getstream() Or (local1 > $12)) <> 0) Then
            Exit
        EndIf
    Wend
    Return $00
End Function
