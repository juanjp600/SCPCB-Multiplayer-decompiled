Function setnpcid%(arg0.npcs, arg1%)
    m_npc[arg0\Field6] = Null
    arg0\Field6 = arg1
    m_npc[arg0\Field6] = arg0
    Return $00
End Function
