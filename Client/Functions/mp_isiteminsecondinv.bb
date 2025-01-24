Function mp_isiteminsecondinv%(arg0.items, arg1.items)
    Local local0%
    If (arg1 = Null) Then
        Return $00
    EndIf
    For local0 = $00 To (arg1\Field20 - $01) Step $01
        If (arg1\Field18[local0] = arg0) Then
            Return $01
        EndIf
    Next
    Return $00
    Return $00
End Function
