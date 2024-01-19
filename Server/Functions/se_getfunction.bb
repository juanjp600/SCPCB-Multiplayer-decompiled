Function se_getfunction.se_vf_funcptr(arg0$)
    Local local0.se_functiondef
    For local0 = Each se_functiondef
        If (local0\Field0\Field0 = arg0) Then
            Return local0\Field0
        EndIf
    Next
    Return Null
End Function
