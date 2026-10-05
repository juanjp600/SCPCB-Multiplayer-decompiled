Function breach_getcategorybytype%(arg0%, arg1%)
    Local local0.breachtypes
    For local0 = Each breachtypes
        If (local0\Field1 = arg0) Then
            Return local0\Field13
        EndIf
    Next
    Return $00
End Function
