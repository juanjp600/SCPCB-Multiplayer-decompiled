Function se_getvariable.se_vf_value(arg0$)
    Local local0.se_localdef
    Local local1.se_staticdef
    Local local2.se_globaldef
    Local local3.se_publicdef
    local0 = se_function_def\Field1
    While (local0 <> Null)
        If (local0\Field1 = arg0) Then
            Return local0\Field0
        EndIf
        local0 = local0\Field2
    Wend
    local1 = se_function_def\Field3
    While (local1 <> Null)
        If (local1\Field1 = arg0) Then
            Return local1\Field0
        EndIf
        local1 = local1\Field2
    Wend
    For local2 = Each se_globaldef
        If (local2\Field1 = arg0) Then
            Return local2\Field0
        EndIf
    Next
    For local3 = Each se_publicdef
        If (local3\Field1 = arg0) Then
            Return local3\Field0
        EndIf
    Next
    local0 = (New se_localdef)
    local0\Field1 = arg0
    local0\Field0 = se_vf_createtransient(se_function_def\Field0, $00)
    If (se_function_def\Field1 = Null) Then
        se_function_def\Field1 = local0
        se_function_def\Field2 = local0
    Else
        se_function_def\Field2\Field2 = local0
        se_function_def\Field2 = local0
    EndIf
    Return local0\Field0
    Return Null
End Function
