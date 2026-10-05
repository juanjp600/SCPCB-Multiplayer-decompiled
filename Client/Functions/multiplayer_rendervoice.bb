Function multiplayer_rendervoice%()
    Local local0%
    Local local1%
    Local local2%
    Local local3%
    Local local4%
    Local local5%
    Local local6%
    Local local7%
    Local local8%
    If (hudenabled <> 0) Then
        If (networkserver\Field52\Field10 = $01) Then
            If ((((voice\Field3 <> $00) And (have_querys() = $00)) And (((local0 <> $00) Or (local1 <> $00)) = $00)) <> 0) Then
                local2 = imenuscale[$32]
                local3 = local2
                local4 = (viewport_center_x - imenuscale[$19])
                local5 = ((graphicheight - imenuscale[$14]) - imenuscale[(($14 * mainmenuopen) + $46)])
                local6 = local4
                local7 = local5
                local8 = imenuscale[$02]
                drawframeblack(local6, local7, local2, local3, $00, $00)
                local6 = (local6 + local8)
                local7 = (local7 + local3)
                setcolorex($F1, $18, $4F)
                renderprogressbary(local6, local7, (local2 - local8), (local3 - local8), 0.2, max(voice\Field16, 0.0))
                If (voice\Field4 <> 0) Then
                    voice\Field16 = curvevalue((voice_get_offset() - 0.74), voice\Field16, 7.0)
                    drawimage(mpimg\Field0, local4, local5, $00)
                Else
                    voice\Field16 = curvevalue(0.0, voice\Field16, 2.0)
                    drawimage(mpimg\Field1, local4, local5, $00)
                EndIf
            EndIf
        EndIf
    EndIf
    Return $00
End Function
