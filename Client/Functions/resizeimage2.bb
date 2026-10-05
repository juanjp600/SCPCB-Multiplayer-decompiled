Function resizeimage2%(arg0%, arg1%, arg2%)
    Local local0%
    Local local1%
    Local local2%
    resizeimage(arg0, (Float arg1), (Float arg2))
    Return arg0
    local0 = createimage(arg1, arg2, $01)
    local1 = imagewidth(arg0)
    local2 = imageheight(arg0)
    copyrect($00, $00, local1, local2, (smallest_power_two_half - (local1 Shr $01)), (smallest_power_two_half - (local2 Shr $01)), imagebuffer(arg0, $00), texturebuffer(fresize_texture, $00))
    setbuffer(backbuffer())
    copyrect(((win\Field2 Shr $01) - (arg1 Shr $01)), ((win\Field3 Shr $01) - (arg2 Shr $01)), arg1, arg2, $00, $00, backbuffer(), imagebuffer(local0, $00))
    freeimage(arg0)
    Return local0
    Return $00
End Function
