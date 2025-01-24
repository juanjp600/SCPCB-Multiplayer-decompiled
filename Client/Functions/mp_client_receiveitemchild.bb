Function mp_client_receiveitemchild%(arg0%, arg1.items)
    Local local0%
    Local local1.items
    local0 = mp_readint()
    local1 = mp_items[arg0]
    If (local1 = Null) Then
        local1 = createitemfromtemplate(local0, 0.0, 0.0, 0.0, $00, $00, $00, 1.0, $00)
        entitytype(local1\Field2, $03, $00)
        mp_initializeitem(local1, arg0)
        local1\Field31 = 0.0
    ElseIf (local1\Field4\Field21 <> local0) Then
        removeitem(local1)
        local1 = createitemfromtemplate(local0, 0.0, 0.0, 0.0, $00, $00, $00, 1.0, $00)
        entitytype(local1\Field2, $03, $00)
        mp_initializeitem(local1, arg0)
        local1\Field31 = 0.0
    EndIf
    local1\Field28 = $01
    If (0.0 < local1\Field31) Then
        Return $00
    EndIf
    local1\Field26 = arg1\Field19
    local1\Field27 = mp_getmyindex()
    local1\Field15 = $01
    Return $00
End Function
