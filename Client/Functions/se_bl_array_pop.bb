Function se_bl_array_pop%()
    Local local0.se_array
    Local local1%
    Local local2.se_value
    Local local4%
    Local local5%
    Local local6%
    Local local7%
    If (se_argtype($00) <> $07) Then
        Return $00
    EndIf
    local0 = se_arrayarg($00)
    If (local0\Field1 = $00) Then
        Return $00
    EndIf
    local1 = (local0\Field1 - $01)
    local2 = (Object.se_value peekint(local0\Field2, (local1 Shl $02)))
    Select local2\Field0
        Case $01
            se_returnint(local2\Field1)
        Case $02
            se_returnfloat(local2\Field2)
        Case $03
            se_returnstring(local2\Field3)
        Case $05
            se_returnpointer(local2\Field4)
        Case $07
            se_returnarray(local2\Field5)
    End Select
    local0\Field1 = (local0\Field1 - $01)
    local4 = local0\Field2
    local5 = (local0\Field1 Shl $02)
    local6 = (local1 Shl $02)
    se_gccheck(local2)
    Delete local2
    local7 = createbank(local5)
    copybank(local4, $00, local7, $00, local5)
    freebank(local0\Field2)
    local0\Field2 = local7
    Return $00
End Function
