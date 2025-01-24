Function mp_issecondinvempty%(arg0.items)
    Local local0%
    If (arg0 = Null) Then
        Return $00
    EndIf
    For local0 = $00 To (arg0\Field20 - $01) Step $01
        If (arg0\Field18[local0] <> Null) Then
            Return $00
        EndIf
    Next
    Return $01
    Return $00
End Function
