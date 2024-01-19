Function resetnpc%(arg0.npcs, arg1%)
    Local local0#
    Local local1#
    Local local2#
    If (arg0\Field5 = arg1) Then
        Return $00
    EndIf
    local0 = entityx(arg0\Field4, $00)
    local1 = entityy(arg0\Field4, $00)
    local2 = entityz(arg0\Field4, $00)
    If (arg0\Field1 <> $00) Then
        freeentity(arg0\Field1)
        arg0\Field1 = $00
    EndIf
    If (arg0\Field2 <> $00) Then
        freeentity(arg0\Field2)
        arg0\Field2 = $00
    EndIf
    If (arg0\Field3 <> $00) Then
        freeentity(arg0\Field3)
        arg0\Field3 = $00
    EndIf
    freeentity(arg0\Field0)
    arg0\Field0 = $00
    freeentity(arg0\Field4)
    arg0\Field4 = $00
    fillnpc(arg0, arg1)
    arg0\Field5 = arg1
    If (arg0\Field4 = $00) Then
        arg0\Field4 = createpivot($00)
        entityradius(arg0\Field4, 0.32, 0.0)
        entitytype(arg0\Field4, $02, $00)
    EndIf
    positionentity(arg0\Field4, local0, local1, local2, $01)
    resetentity(arg0\Field4)
    Return $00
End Function
