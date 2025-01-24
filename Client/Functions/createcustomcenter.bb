Function createcustomcenter%(arg0.rooms, arg1#, arg2#)
    arg0\Field30 = createpivot($00)
    positionentity(arg0\Field30, arg1, 0.0, arg2, $00)
    entityparent(arg0\Field30, arg0\Field2, $01)
    Return $00
End Function
