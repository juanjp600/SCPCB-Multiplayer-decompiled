Function mp_client_receiveitem%(arg0%)
    Local local0%
    Local local1%
    Local local2.items
    local0 = mp_readint()
    local1 = mp_readbyte()
    local2 = mp_items[arg0]
    If (local2 = Null) Then
        local2 = createitemfromtemplate(local0, 0.0, 0.0, 0.0, $00, $00, $00, 1.0, $00)
        entitytype(local2\Field2, $03, $00)
        mp_initializeitem(local2, arg0)
        local2\Field31 = 0.0
    ElseIf (local2\Field4\Field21 <> local0) Then
        removeitem(local2)
        local2 = createitemfromtemplate(local0, 0.0, 0.0, 0.0, $00, $00, $00, 1.0, $00)
        entitytype(local2\Field2, $03, $00)
        mp_initializeitem(local2, arg0)
        local2\Field31 = 0.0
    EndIf
    mp_client_receiveitemtype(local2, local1)
    local2\Field28 = $01
    If (local1 = $00) Then
        local2\Field32 = mp_readfloat()
        local2\Field33 = mp_readfloat()
        local2\Field34 = mp_readfloat()
    EndIf
    If (0.0 < local2\Field31) Then
        Return $00
    EndIf
    If (((local2\Field27 <> local1) And (local2\Field27 = mp_getmyindex())) <> 0) Then
        mp_client_analyzeitem(local2, $01)
    EndIf
    local2\Field27 = local1
    local2\Field15 = (local2\Field27 > $00)
    Return $00
End Function
