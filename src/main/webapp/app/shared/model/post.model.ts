export interface IPost {
  id?: number;
  title?: string;
  body?: string;
}

export const defaultValue: Readonly<IPost> = {};
