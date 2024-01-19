Function removeitem%(arg0.items, arg1%)
    freeentity(arg0\Field1)
    m_item[arg0\Field18] = Null
    Delete arg0
    Return $00
End Function
