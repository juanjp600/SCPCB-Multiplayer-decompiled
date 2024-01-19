Function gg_set_color%(arg0.tgg_textline, arg1%, arg2%, arg3%)
    Local local0%
    If (arg0 = Null) Then
        Return $00
    EndIf
    For local0 = $01 To $FA Step $01
        If (arg0\Field2[local0] = $00) Then
            Return $00
        EndIf
        entitycolor(arg0\Field2[local0], (Float arg1), (Float arg2), (Float arg3))
    Next
    Return $00
End Function
