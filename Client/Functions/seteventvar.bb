Function seteventvar%(arg0.events)
    Select arg0\Field0
        Case "exit1"
            exit1event = arg0
        Case "gatea"
            gateaevent = arg0
        Case "173"
            event173 = arg0
        Case "dimension1499"
            dimension1499 = arg0
        Case "room3storage"
            room3storageevent = arg0
        Case "room860"
            room860event = arg0
        Case "breach"
            breachevent = arg0
        Case "pocketdimension"
            pocketdimension106 = arg0
    End Select
    seteventid(arg0, findfreeeventid())
    Return $00
End Function
