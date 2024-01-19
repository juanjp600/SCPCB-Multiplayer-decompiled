Function se_getconstant.se_vf_value(arg0$)
    Local local0.se_constantdef
    For local0 = Each se_constantdef
        If (local0\Field0 = arg0) Then
            Return se_vf_createbasic(local0\Field1, local0\Field2)
        EndIf
    Next
    Return Null
End Function
