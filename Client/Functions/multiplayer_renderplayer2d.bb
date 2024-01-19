Function multiplayer_renderplayer2d%(arg0.players)
    Local local0#
    If (spectate\Field1 = arg0\Field0) Then
        aasetfont(font1_2)
        local0 = ((Float graphicheight) - (50.0 * menuscale))
        disableredirectaccess = $01
        color($FF, $FF, $FF)
        aatext((Int (20.0 * menuscale)), (Int local0), arg0\Field24, $00, $00, 1.0)
        disableredirectaccess = $00
        If (((gettypename(arg0\Field51) <> " ") And (gettypename(arg0\Field51) <> "")) <> 0) Then
            local0 = (local0 - (35.0 * menuscale))
            settypecolor(arg0\Field51)
            aatext((Int (20.0 * menuscale)), (Int local0), gettypename(arg0\Field51), $00, $00, 1.0)
        EndIf
        If (arg0\Field88 <> "") Then
            local0 = (local0 - (35.0 * menuscale))
            color(arg0\Field89, arg0\Field90, arg0\Field91)
            aatext((Int (20.0 * menuscale)), (Int local0), arg0\Field88, $00, $00, 1.0)
        EndIf
        aasetfont(font1)
        color($FF, $FF, $FF)
        If (mp_instructionsdone = $00) Then
            If (((voice\Field3 <> $00) And (networkserver\Field24 = $01)) <> 0) Then
                aatext((Int ((Float graphicwidth) - ((10.0 * menuscale) + (Float aastringwidth("Use LMB or RMB to switch between players"))))), (Int ((Float graphicheight) - (120.0 * menuscale))), "Press R to switch camera mode", $00, $00, 1.0)
                aatext((Int ((Float graphicwidth) - ((10.0 * menuscale) + (Float aastringwidth("Use LMB or RMB to switch between players"))))), (Int ((Float graphicheight) - (100.0 * menuscale))), "Use LMB or RMB to switch between players", $00, $00, 1.0)
            Else
                aatext((Int ((Float graphicwidth) - ((10.0 * menuscale) + (Float aastringwidth("Use LMB or RMB to switch between players"))))), (Int ((Float graphicheight) - (70.0 * menuscale))), "Press R to switch camera mode", $00, $00, 1.0)
                aatext((Int ((Float graphicwidth) - ((10.0 * menuscale) + (Float aastringwidth("Use LMB or RMB to switch between players"))))), (Int ((Float graphicheight) - (50.0 * menuscale))), "Use LMB or RMB to switch between players", $00, $00, 1.0)
            EndIf
        EndIf
    EndIf
    If (mainmenuopen = $00) Then
        If (myplayer\Field51 = model_096) Then
            If (scp\Field5[arg0\Field0] = $01) Then
                drawprojectedimage(sprinticon, camera, arg0\Field13)
            EndIf
        EndIf
    EndIf
    Return $00
End Function
