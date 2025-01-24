Function removelever%(arg0.levers)
    freeentity(arg0\Field0)
    arg0\Field0 = $00
    freeentity(arg0\Field1)
    arg0\Field1 = $00
    Delete arg0
    Return $00
End Function
