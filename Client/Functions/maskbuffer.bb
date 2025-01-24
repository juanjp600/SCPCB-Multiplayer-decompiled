Function maskbuffer%(arg0%, arg1%, arg2%)
    Local local0%
    Local local1%
    If (arg0 <> $00) Then
        lockbuffer(arg0)
        For local0 = $00 To (arg1 - $01) Step $01
            For local1 = $00 To (arg2 - $01) Step $01
                writepixelfast(local0, local1, $00, arg0)
            Next
        Next
        unlockbuffer(arg0)
    EndIf
    Return $00
End Function
