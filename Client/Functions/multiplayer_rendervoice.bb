Function multiplayer_rendervoice%()
    Local local0#
    Local local1#
    Local local2#
    Local local3#
    If (((((voice\Field3 <> $00) And (networkserver\Field24 = $01)) And (have_querys() = $00)) And (((currentworkshopdownloaditems <> $00) Or (currentworkshopuploadingitems <> $00)) = $00)) <> 0) Then
        local0 = ((Float graphicwidth) - (60.0 * menuscale))
        local1 = ((Float graphicheight) - (((20.0 * (Float mainmenuopen)) + 70.0) * menuscale))
        local2 = ((Float graphicwidth) - (60.0 * menuscale))
        local3 = ((Float graphicheight) - (((20.0 * (Float mainmenuopen)) + 70.0) * menuscale))
        drawframeblack((Int local2), (Int local3), (Int (50.0 * menuscale)), (Int (50.0 * menuscale)), $00, $00)
        local2 = ((2.0 * menuscale) + local2)
        local3 = ((50.0 * menuscale) + local3)
        color($F1, $18, $4F)
        renderprogressbary((Int local2), (Int local3), (Int ((50.0 * menuscale) - (2.0 * menuscale))), (Int ((50.0 * menuscale) - (2.0 * menuscale))), 0.2, max(voice\Field16, 0.0))
        If (voice\Field4 <> 0) Then
            voice\Field16 = curvevalue((voice_get_offset() - 0.74), voice\Field16, 7.0)
            drawimage(mpimg\Field2, (Int local0), (Int local1), $00)
        Else
            voice\Field16 = curvevalue(0.0, voice\Field16, 7.0)
            drawimage(mpimg\Field3, (Int local0), (Int local1), $00)
        EndIf
    EndIf
    Return $00
End Function
