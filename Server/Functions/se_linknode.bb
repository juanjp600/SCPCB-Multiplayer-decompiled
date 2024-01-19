Function se_linknode%(arg0.se_node, arg1.se_node, arg2%)
    Local local0.se_node
    Local local1%
    local0 = arg0\Field6
    If (local0 <> Null) Then
        local1 = (arg0\Field3 > local0\Field3)
        If (arg0\Field7 <> Null) Then
            arg0\Field7\Field8 = arg0\Field8
        Else
            local0\Field4[local1] = arg0\Field8
        EndIf
        If (arg0\Field8 <> Null) Then
            arg0\Field8\Field7 = arg0\Field7
        Else
            local0\Field5[local1] = arg0\Field7
        EndIf
        arg0\Field7 = Null
        arg0\Field8 = Null
    EndIf
    arg0\Field6 = arg1
    local1 = (arg0\Field3 > arg1\Field3)
    If (arg2 <> 0) Then
        If (arg1\Field5[local1] <> Null) Then
            arg0\Field7 = arg1\Field5[local1]
            arg1\Field5[local1]\Field8 = arg0
            arg1\Field5[local1] = arg0
        Else
            arg1\Field4[local1] = arg0
            arg1\Field5[local1] = arg0
        EndIf
    ElseIf (arg1\Field4[local1] <> Null) Then
        arg0\Field8 = arg1\Field4[local1]
        arg1\Field4[local1]\Field7 = arg0
        arg1\Field4[local1] = arg0
    Else
        arg1\Field4[local1] = arg0
        arg1\Field5[local1] = arg0
    EndIf
    Return $00
End Function
