Function multiplayer_renderplayer2d%(arg0.players)
    Local local0%
    Local local1%
    Local local2%
    Local local3%
    Local local4%
    Local local5%
    Local local6%
    Local local7$
    Local local8%
    If (spectate\Field1 = arg0\Field0) Then
        local0 = imenuscale[$14]
        local1 = (graphicheight - imenuscale[$32])
        local2 = $01
        setfontex(fonts[$00]\Field0)
        setcolorraw($FFFFFF)
        local3 = stringwidth(arg0\Field24)
        local4 = stringheight(arg0\Field24)
        local5 = imenuscale[$05]
        local6 = imenuscale[$0A]
        drawframe((local0 - local5), (local1 - local5), (local3 + local6), (local4 + local6), $00, $00)
        text(local0, local1, arg0\Field24, $00, $00)
        local2 = $00
        If (((gettypename(arg0\Field49) <> " ") And (gettypename(arg0\Field49) <> "")) <> 0) Then
            local1 = (local1 - imenuscale[$23])
            local7 = gettypename(arg0\Field49)
            drawframe((local0 - local5), (local1 - local5), (stringwidth(local7) + local6), (stringheight(local7) + local6), $00, $00)
            settypecolor(arg0\Field49)
            text(local0, local1, local7, $00, $00)
        EndIf
        If (arg0\Field86 <> "") Then
            local1 = (local1 - imenuscale[$23])
            setcolorex(arg0\Field87, arg0\Field88, arg0\Field89)
            drawframe((local0 - local5), (local1 - local5), (stringwidth(arg0\Field86) + local6), (local4 + local6), $00, $00)
            text(local0, local1, arg0\Field86, $00, $00)
        EndIf
        If (mp_instructionsdone = $00) Then
            setfontex(fonts[$00]\Field0)
            setcolorraw($FFFFFF)
            If (((voice\Field3 <> $00) And (networkserver\Field52\Field10 = $01)) <> 0) Then
                local0 = (graphicwidth - imenuscale[$195])
                local1 = (graphicheight - imenuscale[$78])
                local8 = (graphicheight - imenuscale[$64])
            Else
                local0 = (graphicwidth - imenuscale[$195])
                local1 = (graphicheight - imenuscale[$46])
                local8 = (graphicheight - imenuscale[$32])
            EndIf
            drawframe((local0 - local5), (local1 - local5), ((len("Use LMB or RMB to switch between players") * local3) + local6), (((local4 + local4) + local6) + local6), $00, $00)
            text(local0, local1, "Press R to switch camera mode", $00, $00)
            text(local0, local8, "Use LMB or RMB to switch between players", $00, $00)
        EndIf
    EndIf
    If (mainmenuopen = $00) Then
        If (myplayer\Field49 = model_096) Then
            If (scp\Field5[arg0\Field0] = $01) Then
                drawprojectedimage(sprinticon, camera, arg0\Field13)
            EndIf
        EndIf
    EndIf
    Return $00
End Function
