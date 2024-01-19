Function se_compileidentifier.se_vf_value(arg0.se_node)
    Local local0.se_vf_value
    If (arg0\Field4[$01] = Null) Then
        local0 = se_getconstant(arg0\Field0\Field1)
        If (local0 <> Null) Then
            Return local0
        EndIf
        Return se_getvariable(arg0\Field0\Field1)
    Else
        se_compilenode(arg0\Field4[$01])
    EndIf
    Return Null
End Function
