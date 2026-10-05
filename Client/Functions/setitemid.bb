Function setitemid%(arg0.items, arg1%)
    m_item[arg0\Field19] = Null
    arg0\Field19 = arg1
    m_item[arg0\Field19] = arg0
    Return $00
End Function
