Function resizeimage2%(arg0%, arg1%, arg2%)
    Local local0%
    Local local1%
    Local local2%
    resizeimage(arg0, (Float arg1), (Float arg2))
    Return arg0
    local0 = createimage(arg1, arg2, $01)
    local1 = imagewidth(arg0)
    local2 = imageheight(arg0)
    copyrect($00, $00, local1, local2, (Int (smallest_power_two_half - (Float (local1 Sar $01)))), (Int (smallest_power_two_half - (Float (local2 Sar $01)))), imagebuffer(arg0, $00), texturebuffer(fresize_texture, $00))
    setbuffer(backbuffer())
    scalerender(0.0, 0.0, (((smallest_power_two / (Float realgraphicwidth)) * (Float arg1)) / (Float local1)), (((smallest_power_two / (Float realgraphicwidth)) * (Float arg2)) / (Float local2)))
    copyrect(((realgraphicwidth Sar $01) - (arg1 Sar $01)), ((realgraphicheight Sar $01) - (arg2 Sar $01)), arg1, arg2, $00, $00, backbuffer(), imagebuffer(local0, $00))
    freeimage(arg0)
    Return local0
    Return $00
End Function
