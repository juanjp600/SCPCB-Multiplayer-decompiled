Function breach_getcategorybytype%(arg0%, arg1%)
    Local local0.breachtypes
    For local0 = Each breachtypes
        If (local0\Field1 = arg0) Then
            If (((((arg0 = ntf_model) Or (arg0 = haos_model)) Or (arg0 = model_zombie)) And (arg1 = $00)) <> 0) Then
                Return $00
            EndIf
            Return local0\Field13
        EndIf
    Next
    Return $00
End Function
