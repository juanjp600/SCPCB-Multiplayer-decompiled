Function seteventid%(arg0.events, arg1%)
    m_event[arg0\Field15] = Null
    arg0\Field15 = arg1
    m_event[arg0\Field15] = arg0
    Return $00
End Function
