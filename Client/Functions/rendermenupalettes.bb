Function rendermenupalettes%()
    Local local0.menupalette
    Local local1%
    Local local2%
    Local local3%
    local1 = (Int (5.0 * menuscale))
    For local0 = Each menupalette
        drawimage(local0\Field0, local0\Field1, local0\Field2, $00)
        If (mouseon(local0\Field1, local0\Field2, local0\Field3, local0\Field4) <> 0) Then
            If ((mo\Field2 And (onsliderid = $00)) <> 0) Then
                local2 = backbuffer()
                lockbuffer(local2)
                local3 = readpixelfast((Int mouseposx), (Int mouseposy), local2)
                unlockbuffer(local2)
                opt\Field27 = readpixelcolor(local3, $10)
                opt\Field28 = readpixelcolor(local3, $08)
                opt\Field29 = readpixelcolor(local3, $00)
            EndIf
            color($00, $00, $00)
            oval((Int mouseposx), (Int mouseposy), local1, local1, $00)
        EndIf
    Next
    Return $00
End Function
