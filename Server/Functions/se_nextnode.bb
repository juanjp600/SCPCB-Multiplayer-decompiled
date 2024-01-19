Function se_nextnode.se_node(arg0.se_node)
    If (((arg0\Field1 = $03) Or (arg0\Field1 = $01)) <> 0) Then
        Return arg0\Field8
    ElseIf (arg0\Field1 = $04) Then
        arg0 = arg0\Field8
        Repeat
            If (arg0 = Null) Then
                Return Null
            EndIf
            If (arg0\Field1 <> $04) Then
                Return arg0
            EndIf
            arg0 = arg0\Field8
        Forever
    EndIf
    Return Null
End Function
