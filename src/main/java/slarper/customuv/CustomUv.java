package slarper.customuv;

import net.minecraft.client.model.ModelPart;
import net.minecraft.util.math.Direction;
import slarper.customuv.mixin.CuboidAccessor;
import slarper.customuv.mixin.ModelPartAccessor;

public class CustomUv {
    private CustomUv() {
    }

    public static int getFaceByDirection(Direction direction){
        return switch (direction){
            case UP -> 3;
            case DOWN -> 2;
            case WEST -> 1;
            case NORTH -> 4;
            case EAST -> 0;
            case SOUTH -> 5;
        };
    }

    public static ModelPart.Vertex[] getFace(ModelPart model, int cuboid, Direction face){
        ModelPart.Cuboid cube = ((ModelPartAccessor)model).getCuboids().get(cuboid);
        ModelPart.Quad side = ((CuboidAccessor)cube).getSides()[getFaceByDirection(face)];
        return side.vertices;
    }

    public static void setUv(float minU, float minV, float maxU, float maxV, float textureSizeU, float textureSizeV,
                             ModelPart.Vertex[] vertices,
                             int upRightCorner, int upLeftCorner, int downLeftCorner, int downRightCorner
    ){
        vertices[upRightCorner] = vertices[upRightCorner].remap(maxU / textureSizeU, minV / textureSizeV);
        vertices[upLeftCorner] = vertices[upLeftCorner].remap(minU / textureSizeU, minV / textureSizeV);
        vertices[downLeftCorner] = vertices[downLeftCorner].remap(minU / textureSizeU, maxV / textureSizeV);
        vertices[downRightCorner] = vertices[downRightCorner].remap(maxU / textureSizeU, maxV / textureSizeV);
    }
}
