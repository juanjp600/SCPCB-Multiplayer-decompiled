Function clearsecondinv%(arg0.items, arg1%)
    Local local0%
    For local0 = arg1 To (arg0\Field20 - $01) Step $01
        If (arg0\Field18[local0] <> Null) Then
            removeitem(arg0\Field18[local0])
            arg0\Field18[local0] = Null
        EndIf
    Next
    Return $00
End Function
