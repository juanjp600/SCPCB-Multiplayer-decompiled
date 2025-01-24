Function deinitmainmenuassets%()
    freeimage(mma\Field0)
    mma\Field0 = $00
    freeimage(mma\Field1)
    mma\Field1 = $00
    freeimage(mma\Field2)
    mma\Field2 = $00
    Delete mma
    mma = Null
    Delete mm
    mm = Null
    Return $00
End Function
