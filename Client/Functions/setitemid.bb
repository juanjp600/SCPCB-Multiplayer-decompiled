Function setitemid%(arg0.items, arg1%)
    m_item[arg0\Field18] = Null
    arg0\Field18 = arg1
    m_item[arg0\Field18] = arg0
    Return $00
End Function
