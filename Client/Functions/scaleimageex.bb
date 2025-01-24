Function scaleimageex%(arg0%, arg1#, arg2#, arg3%)
    Local local0%
    Local local1%
    Local local2%
    Local local3%
    Local local4%
    Local local5%
    Local local6%
    Local local7%
    Local local8%
    Local local9%
    Local local10%
    Local local11%
    Local local12%
    Local local13%
    local0 = imagewidth(arg0)
    local1 = imageheight(arg0)
    local2 = (Int floor(((Float local0) * arg1)))
    local3 = (Int floor(((Float local1) * arg2)))
    If (((local0 = local2) And (local1 = local3)) <> 0) Then
        Return arg0
    EndIf
    local4 = createimage(local2, local1, arg3)
    local5 = createimage(local2, local3, arg3)
    For local13 = $00 To (arg3 - $01) Step $01
        local6 = imagebuffer(arg0, local13)
        local7 = imagebuffer(local4, local13)
        local8 = imagebuffer(local5, local13)
        For local11 = $00 To (local2 - $01) Step $01
            local9 = (Int floor(((Float local11) / arg1)))
            copyrect(local9, $00, $01, local1, local11, $00, local6, local7)
        Next
        For local12 = $00 To (local3 - $01) Step $01
            local10 = (Int floor(((Float local12) / arg2)))
            copyrect($00, local10, local2, $01, $00, local12, local7, local8)
        Next
    Next
    freeimage(local4)
    local4 = $00
    freeimage(arg0)
    arg0 = $00
    Return local5
    Return $00
End Function
