Function createnpc.npcs(arg0%, arg1#, arg2#, arg3#)
    Local local0.npcs
    If (networkserver\Field12 = $01) Then
        Return Null
    EndIf
    local0 = (New npcs)
    local0\Field5 = arg0
    local0\Field49 = $01
    local0\Field59 = $01
    local0\Field44 = 1.0
    local0\Field45 = 0.2
    local0\Field70 = 0.2
    local0\Field74 = 10.0
    local0\Field69 = $00
    local0\Field78 = 700.0
    fillnpc(local0, arg0)
    positionentity(local0\Field4, arg1, arg2, arg3, $01)
    positionentity(local0\Field0, arg1, arg2, arg3, $01)
    resetentity(local0\Field4)
    local0\Field6 = $00
    local0\Field6 = findfreenpcid()
    m_npc[local0\Field6] = local0
    npcspeedchange(local0)
    npccount = (npccount + $01)
    Return local0
    Return Null
End Function
