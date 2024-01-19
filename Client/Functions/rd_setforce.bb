Function rd_setforce%(arg0.rd_bone, arg1#, arg2#, arg3#)
    moveentity(arg0\Field0, min((arg1 * fpsfactor), 1.0), min((arg2 * fpsfactor), 1.0), min((arg3 * fpsfactor), 1.0))
    Return $00
End Function
