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
    If (menubrowser <> Null) Then
        steambrowser_destroy(menubrowser)
    EndIf
    If ((((networkserver\Field68 <> "") And (api_steamhtml = $01)) And (menubrowser = Null)) <> 0) Then
        menubrowser = steambrowser_create(graphicwidth, graphicheight, networkserver\Field68, "SteamBrowser", "")
    EndIf
    flushkeys()
    While (keyhit($01) = $00)
        clscolor($00, $00, $00)
        cls()
        steam_update()
        discord_api_update()
        If (menubrowser <> Null) Then
            bs_isteamhtmlsurface_mousemove(bs_steamhtmlsurface(), menubrowser\Field0, mousex(), mousey())
            If (mousedown($01) <> 0) Then
                bs_isteamhtmlsurface_mousedown(bs_steamhtmlsurface(), menubrowser\Field0, $00)
            Else
                bs_isteamhtmlsurface_mouseup(bs_steamhtmlsurface(), menubrowser\Field0, $00)
            EndIf
        EndIf
        If (selectedloadingscreen\Field6 = $00) Then
            drawimage(loadingback, ((graphicwidth Sar $01) - (imagewidth(loadingback) Sar $01)), ((graphicheight Sar $01) - (imageheight(loadingback) Sar $01)), $00)
        EndIf
        If (menubrowser = Null) Then
            If (selectedloadingscreen\Field6 = $00) Then
                drawimage(loadingback, ((graphicwidth Sar $01) - (imagewidth(loadingback) Sar $01)), ((graphicheight Sar $01) - (imageheight(loadingback) Sar $01)), $00)
            EndIf
            If (selectedloadingscreen\Field4 = $00) Then
                local3 = ((graphicwidth Sar $01) - (imagewidth(selectedloadingscreen\Field1) Sar $01))
            ElseIf (selectedloadingscreen\Field4 = $01) Then
                local3 = (graphicwidth - imagewidth(selectedloadingscreen\Field1))
            Else
                local3 = $00
            EndIf
            If (selectedloadingscreen\Field5 = $00) Then
                local4 = ((graphicheight Sar $01) - (imageheight(selectedloadingscreen\Field1) Sar $01))
            ElseIf (selectedloadingscreen\Field5 = $01) Then
                local4 = (graphicheight - imageheight(selectedloadingscreen\Field1))
            Else
                local4 = $00
            EndIf
            drawimage(selectedloadingscreen\Field1, local3, local4, $00)
        Else
            drawblock(steambrowser_getimagehandle(menubrowser), $00, $00, $00)
        EndIf
        local5 = $12C
        local6 = $14
        local3 = ((graphicwidth Sar $01) - (local5 Sar $01))
        local4 = (((graphicheight Sar $01) + $1E) - $64)
        color($00, $00, $00)
        aasetfont(font2)
        aatext(((graphicwidth Sar $01) + $01), (((graphicheight Sar $01) + $50) + $01), selectedloadingscreen\Field3, $01, $01, 1.0)
        aasetfont(font1)
        rowtext(selectedloadingscreen\Field7[loadingscreentext], (Float (((graphicwidth Sar $01) - $C8) + $01)), (Float (((graphicheight Sar $01) + $78) + $01)), 400.0, 300.0, $01, 1.0, $00)
        color($FF, $FF, $FF)
        aasetfont(font2)
        aatext((graphicwidth Sar $01), ((graphicheight Sar $01) + $50), selectedloadingscreen\Field3, $01, $01, 1.0)
        aasetfont(font1)
        rowtext(selectedloadingscreen\Field7[loadingscreentext], (Float ((graphicwidth Sar $01) - $C8)), (Float ((graphicheight Sar $01) + $78)), 400.0, 300.0, $01, 1.0, $00)
        aasetfont(font2)
        color($AA, $AA, $AA)
        aatext((graphicwidth Sar $01), (Int ((Float (graphicheight Sar $01)) - (200.0 * menuscale))), "SERVER IS RESTARTING", $01, $01, 1.0)
        color($FF, $FF, $FF)
        aasetfont(font1)
        aatext((Int (20.0 * menuscale)), (Int (20.0 * menuscale)), "Press ESC To exit", $00, $00, 1.0)
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
        updateresolution($01, $00)
        shouldrestartserver = $00
        If ((udp_getstream() Or (local1 > $12)) <> 0) Then
            Exit
        EndIf
    Wend
    If (menubrowser <> Null) Then
        steambrowser_destroy(menubrowser)
    EndIf
    Return $00
End Function
