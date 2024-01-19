Function breach_getcategorycolor%(arg0%)
    Local local0.breachtypes
    For local0 = Each breachtypes
        If (local0\Field13 = arg0) Then
            color(local0\Field5, local0\Field6, local0\Field7)
            Exit
        EndIf
    Next
    Return $00
End Function
