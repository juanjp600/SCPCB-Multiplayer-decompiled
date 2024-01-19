Function se_array_freeelement%(arg0.se_array, arg1%)
    Local local0%
    Local local1%
    Local local2%
    Local local3.se_value
    Local local4%
    If (arg0\Field1 = $00) Then
        Return $00
    EndIf
    If (((arg1 >= $00) And (arg1 <= arg0\Field1)) <> 0) Then
        arg0\Field1 = (arg0\Field1 - $01)
        local0 = arg0\Field2
        local1 = (arg0\Field1 Shl $02)
        local2 = (arg1 Shl $02)
        local3 = (Object.se_value peekint(local0, local2))
        se_gccheck(local3)
        Delete local3
        local4 = createbank(local1)
        If (local2 = $00) Then
            copybank(local0, $04, local4, $00, local1)
        ElseIf (local2 = local1) Then
            copybank(local0, $00, local4, $00, local1)
        Else
            copybank(local0, $00, local4, $00, local2)
            copybank(local0, (local2 + $04), local4, local2, (local1 - local2))
        EndIf
        freebank(arg0\Field2)
        arg0\Field2 = local4
    EndIf
    Return $00
End Function
