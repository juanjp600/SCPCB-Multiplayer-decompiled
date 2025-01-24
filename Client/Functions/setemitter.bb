Function setemitter.emitter(arg0.rooms, arg1#, arg2#, arg3#, arg4%)
    Local local0.emitter
    Local local1%
    local0 = (New emitter)
    local0\Field10 = arg0
    local0\Field4 = arg4
    local0\Field6 = createpivot($00)
    positionentity(local0\Field6, arg1, arg2, arg3, $00)
    If (arg0 <> Null) Then
        entityparent(local0\Field6, arg0\Field2, $01)
    EndIf
    local0\Field7 = createmesh($00)
    local0\Field8 = createsurface(local0\Field7, $00)
    local0\Field3 = (Object.template particleeffect[arg4])
    local0\Field2 = (Float local0\Field3\Field0)
    entityblend(local0\Field7, local0\Field3\Field1)
    entityfx(local0\Field7, $23)
    If (local0\Field3\Field7 <> $00) Then
        entitytexture(local0\Field7, local0\Field3\Field7, $00, $00)
    EndIf
    local0\Field5 = $00
    local0\Field5 = findfreeemitterid()
    Return local0
    Return Null
End Function
