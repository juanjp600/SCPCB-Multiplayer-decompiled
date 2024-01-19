Function se_compilenode.se_vf_value(arg0.se_node)
    Local local0.se_token
    local0 = arg0\Field0
    If (local0\Field0 <= $03) Then
        Return se_vf_createbasic(arg0\Field0\Field0, arg0\Field0\Field1)
    ElseIf (local0\Field0 = $04) Then
        Return se_compileidentifier(arg0)
    ElseIf (local0\Field0 = $07) Then
        Return se_compileoperator(arg0)
    ElseIf (local0\Field0 = $05) Then
        se_compileparenthesis(arg0)
    ElseIf (local0\Field0 = $0A) Then
        se_compilearray(arg0)
    EndIf
    Return Null
End Function
