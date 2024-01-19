Function se_checkfunction%(arg0$)
    Local local0.se_functiondef
    For local0 = Each se_functiondef
        If (local0\Field0\Field0 = arg0) Then
            Return $01
        EndIf
    Next
    Return $00
End Function
