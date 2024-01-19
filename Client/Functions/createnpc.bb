Function createnpc.npcs(arg0%, arg1#, arg2#, arg3#)
    Local local0.npcs
    Local local1%
    Local local2%
    Local local3%
    Local local4%
    Local local5%
    Local local6%
    Local local7%
    Local local8%
    Local local9%
    local0 = (New npcs)
    local0\Field5 = arg0
    local0\Field44 = 1.0
    local0\Field45 = 0.2
    local0\Field68 = 0.2
    local0\Field72 = 10.0
    local0\Field67 = $00
    local0\Field76 = 700.0
    fillnpc(local0, arg0)
    positionentity(local0\Field4, arg1, arg2, arg3, $01)
    positionentity(local0\Field0, arg1, arg2, arg3, $01)
    resetentity(local0\Field4)
    local0\Field6 = $00
    local0\Field6 = findfreenpcid()
    m_npc[local0\Field6] = local0
    debuglog((((((("Created NPC " + local0\Field43) + " (ID: ") + (Str local0\Field6)) + ")") + " Type = ") + (Str local0\Field5)))
    npcspeedchange(local0)
    npccount = (npccount + $01)
    Return local0
    Return Null
End Function
