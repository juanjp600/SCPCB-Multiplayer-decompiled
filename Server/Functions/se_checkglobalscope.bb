Function se_checkglobalscope%(arg0$)
    Local local0.se_globaldef
    Local local1.se_publicdef
    For local0 = Each se_globaldef
        If (local0\Field1 = arg0) Then
            Return $01
        EndIf
    Next
    For local1 = Each se_publicdef
        If (local1\Field1 = arg0) Then
            Return $01
        EndIf
    Next
    Return $00
End Function
