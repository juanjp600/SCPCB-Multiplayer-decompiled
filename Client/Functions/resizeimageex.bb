Function resizeimageex%(arg0%, arg1#, arg2#)
    Local local0%
    Local local1%
    Local local2%
    Local local3%
    Local local4%
    Local local5%
    local0 = imagewidth(arg0)
    local1 = imageheight(arg0)
    local2 = (Int floor(((Float local0) * arg1)))
    local3 = (Int floor(((Float local1) * arg2)))
    If (((local0 = local2) And (local1 = local3)) <> 0) Then
        Return arg0
    EndIf
    local4 = createimage(local2, local3, $01)
    local5 = backbuffer()
    copyrect($00, $00, local0, local1, (Int (smallest_power_two_half - (Float (local0 Sar $01)))), (Int (smallest_power_two_half - (Float (local1 Sar $01)))), imagebuffer(arg0, $00), texturebuffer(fresizetexture, $00))
    setbuffer(local5)
    scalerender(0.0, 0.0, (((smallest_power_two / graphicwidthfloat) * (Float local2)) / (Float local0)), (((smallest_power_two / graphicwidthfloat) * (Float local3)) / (Float local1)))
    copyrect((mo\Field9 - (local2 Sar $01)), (mo\Field10 - (local3 Sar $01)), local2, local3, $00, $00, local5, imagebuffer(local4, $00))
    freeimage(arg0)
    arg0 = $00
    bufferdirty(imagebuffer(local4, $00))
    Return local4
    Return $00
End Function
