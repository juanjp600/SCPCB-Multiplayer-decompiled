Function se_checkconstant%(arg0$)
    Local local0.se_constantdef
    For local0 = Each se_constantdef
        If (local0\Field0 = arg0) Then
            Return $01
        EndIf
    Next
    Return $00
End Function
