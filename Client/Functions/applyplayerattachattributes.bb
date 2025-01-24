Function applyplayerattachattributes%(arg0.mp_player, arg1%)
    Local local0.mp_playermodel
    Local local1.mp_playerattach
    Local local2.mp_attachmodelpreset
    Local local3%
    local0 = arg0\Field35
    local1 = local0\Field21[arg1]
    removeplayerattach(local0, arg1, $00)
    local1\Field2 = local1\Field3
    markplayerasupdated(arg0)
    If (local0\Field0 = $00) Then
        Return $00
    EndIf
    If (local1\Field2 = Null) Then
        Return $00
    EndIf
    local2 = getplayerattachpreset(local0, local1\Field2)
    If (((local2 = Null) Lor (local1\Field2\Field3[local2\Field8] = $00)) <> 0) Then
        Return $00
    EndIf
    local3 = findchild(local0\Field0, local2\Field0)
    If (local3 = $00) Then
        Return $00
    EndIf
    local1\Field0 = copyentity(local1\Field2\Field3[local2\Field8], local3)
    positionentity(local1\Field0, local2\Field4, local2\Field5, local2\Field6, $00)
    rotateentity(local1\Field0, local2\Field1, local2\Field2, local2\Field3, $00)
    scaleentity(local1\Field0, local2\Field7, local2\Field7, local2\Field7, $00)
    entitytexture(local1\Field0, local1\Field2\Field4[local2\Field8], $00, $00)
    Return $01
    Return $00
End Function
